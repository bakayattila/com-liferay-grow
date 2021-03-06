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

package com.grow.favourites.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Favourite service. Represents a row in the &quot;FavouritesList_Favourite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.grow.favourites.model.impl.FavouriteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.grow.favourites.model.impl.FavouriteImpl}.
 * </p>
 *
 * @author NorbertNemeth
 * @see Favourite
 * @see com.grow.favourites.model.impl.FavouriteImpl
 * @see com.grow.favourites.model.impl.FavouriteModelImpl
 * @generated
 */
@ProviderType
public interface FavouriteModel extends BaseModel<Favourite>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a favourite model instance should use the {@link Favourite} interface instead.
	 */

	/**
	 * Returns the primary key of this favourite.
	 *
	 * @return the primary key of this favourite
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this favourite.
	 *
	 * @param primaryKey the primary key of this favourite
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this favourite.
	 *
	 * @return the uuid of this favourite
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this favourite.
	 *
	 * @param uuid the uuid of this favourite
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the favourite ID of this favourite.
	 *
	 * @return the favourite ID of this favourite
	 */
	public long getFavouriteId();

	/**
	 * Sets the favourite ID of this favourite.
	 *
	 * @param favouriteId the favourite ID of this favourite
	 */
	public void setFavouriteId(long favouriteId);

	/**
	 * Returns the asset entry ID of this favourite.
	 *
	 * @return the asset entry ID of this favourite
	 */
	public long getAssetEntryId();

	/**
	 * Sets the asset entry ID of this favourite.
	 *
	 * @param assetEntryId the asset entry ID of this favourite
	 */
	public void setAssetEntryId(long assetEntryId);

	/**
	 * Returns the company ID of this favourite.
	 *
	 * @return the company ID of this favourite
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this favourite.
	 *
	 * @param companyId the company ID of this favourite
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this favourite.
	 *
	 * @return the group ID of this favourite
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this favourite.
	 *
	 * @param groupId the group ID of this favourite
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the added date of this favourite.
	 *
	 * @return the added date of this favourite
	 */
	public Date getAddedDate();

	/**
	 * Sets the added date of this favourite.
	 *
	 * @param addedDate the added date of this favourite
	 */
	public void setAddedDate(Date addedDate);

	/**
	 * Returns the user ID of this favourite.
	 *
	 * @return the user ID of this favourite
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this favourite.
	 *
	 * @param userId the user ID of this favourite
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this favourite.
	 *
	 * @return the user uuid of this favourite
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this favourite.
	 *
	 * @param userUuid the user uuid of this favourite
	 */
	public void setUserUuid(String userUuid);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Favourite favourite);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Favourite> toCacheModel();

	@Override
	public Favourite toEscapedModel();

	@Override
	public Favourite toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}