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

package com.liferay.grow.journal.tags.web.internal;

import com.liferay.asset.display.page.constants.AssetDisplayPageWebKeys;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.info.display.contributor.InfoDisplayObjectProvider;
import com.liferay.journal.model.JournalArticle;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Balázs Sáfrány-Kovalik
 */
public class GrowJournalTagsDisplayContext {

    public GrowJournalTagsDisplayContext(HttpServletRequest request) {
        InfoDisplayObjectProvider infoDisplayObjectProvider =
                (InfoDisplayObjectProvider)request.getAttribute(
                        AssetDisplayPageWebKeys.INFO_DISPLAY_OBJECT_PROVIDER);

        if (infoDisplayObjectProvider != null) {
            JournalArticle journalArticle =
                    (JournalArticle)infoDisplayObjectProvider.getDisplayObject();

            _assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
                    JournalArticle.class.getName(),
                    journalArticle.getResourcePrimKey());
        }
    }

    public List<AssetTag> getUnofficialTags() {
        if (_unofficialTags != null) {
            return _unofficialTags;
        }

        _unofficialTags = AssetTagLocalServiceUtil.getAssetEntryAssetTags(
                _assetEntry.getEntryId());

        Iterator<AssetTag> i = _unofficialTags.iterator();

        while (i.hasNext()) {
            AssetTag tag = i.next();

            String tagName = tag.getName();

            tagName = tagName.toLowerCase();

            if (tagName.equals("official")) {
                _official = true;
                i.remove();
            }
        }

        return _unofficialTags;
    }

    public boolean hasOfficial() {
        if (_official != null) {
            return _official;
        }

        _official = false;

        getUnofficialTags();

        return _official;
    }

    public boolean hasTags() {
        if (_hasTags != null) {
            return _hasTags;
        }

        _hasTags = false;

        if ((_assetEntry != null) &&
                (AssetTagLocalServiceUtil.getAssetEntryAssetTagsCount(
                        _assetEntry.getEntryId()) > 0)) {

            _hasTags = true;
        }

        return _hasTags;
    }

    private AssetEntry _assetEntry;
    private Boolean _hasTags;
    private Boolean _official;
    private List<AssetTag> _unofficialTags;

}
