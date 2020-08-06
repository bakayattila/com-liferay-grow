/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.grow.journal.contributors.web;

import com.liferay.asset.display.page.constants.AssetDisplayPageWebKeys;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.grow.journal.contributors.web.dto.Contributor;
import com.liferay.info.display.contributor.InfoDisplayObjectProvider;
import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Balázs Sáfrány-Kovalik
 */
public class JournalContributorsDisplayContext {

    public JournalContributorsDisplayContext(
            HttpServletRequest httpServletRequest) {

        _httpServletRequest = httpServletRequest;

        InfoDisplayObjectProvider infoDisplayObjectProvider =
                (InfoDisplayObjectProvider)httpServletRequest.getAttribute(
                        AssetDisplayPageWebKeys.INFO_DISPLAY_OBJECT_PROVIDER);

        if (infoDisplayObjectProvider != null) {
            _journalArticle =
                    (JournalArticle)infoDisplayObjectProvider.getDisplayObject();

            _assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
                    JournalArticle.class.getName(),
                    _journalArticle.getResourcePrimKey());
        }

        _initContributors();
    }

	public Collection<Contributor> getContributors() {
		long userId = 0;

		if (_journalArticle != null) {
			userId = _journalArticle.getUserId();
		}

		Map<Long, Contributor> nonCreatorContributors = new HashMap<>();

		MapUtil.copy(_contributors, nonCreatorContributors);

		nonCreatorContributors.remove(userId);

		return nonCreatorContributors.values();
	}

    public String getCreateDate() {
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");

        if (_journalArticle == null) {
            return dateFormat.format(new Date());
        }

        return dateFormat.format(_journalArticle.getCreateDate());
    }

    public Contributor getCreator() {
        if (_journalArticle == null) {
            return _contributors.get(0L);
        }

        return _contributors.get(_journalArticle.getUserId());
    }

    public String getModifiedDate() {
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");

        if (_journalArticle == null) {
            return dateFormat.format(new Date());
        }

        return dateFormat.format(_journalArticle.getModifiedDate());
    }

    public Contributor getModifier() {
        if (_journalArticle == null) {
            return _contributors.get(1L);
        }

        return _contributors.get(_journalArticle.getStatusByUserId());
    }

    private Contributor _createContributor(long userId) {
        User user = UserLocalServiceUtil.fetchUser(userId);
        String fullName = "Missing User";

        if (user != null) {
            fullName = user.getFullName();
        }

        return new Contributor(fullName);
    }

    private void _initContributors() {
        _contributors = new HashMap<>();

        if (_journalArticle == null) {
            _contributors.put(
                    0L,
                    new Contributor(
                            "Creator Place Holder"));
            _contributors.put(
                    1L,
                    new Contributor(
                            "Modifier Place Holder"));
			_contributors.put(
					2L, new Contributor("1st Place Holder"));
			_contributors.put(
					3L, new Contributor("2nd Place Holder"));
			_contributors.put(
					4L,	new Contributor("3rd Place Holder"));

        } else {
            List<JournalArticle> journalArticles =
                    JournalArticleLocalServiceUtil.getArticlesByResourcePrimKey(
                            _journalArticle.getResourcePrimKey());

            for (JournalArticle version : journalArticles) {
                long userId = version.getStatusByUserId();

                Contributor contributor = _contributors.get(userId);

                if (contributor == null) {
                    contributor = _createContributor(userId);

                    _contributors.put(userId, contributor);
                }
            }
        }
    }

    private AssetEntry _assetEntry;
    private String _baseUrl;
    private Map<Long, Contributor> _contributors;
    private HttpServletRequest _httpServletRequest;
    private JournalArticle _journalArticle;

}