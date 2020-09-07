<%--
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
--%>

<%@ include file="/init.jsp" %>

<nav class="a-items">
	<input class="activate hidden" id="tags" name="tags" type="checkbox" />

	<label class="accordion-label" for="tags">Tags</label>

	<div class="a-content sbox">
		<ul class="list-unstyled">
			<c:if test="<%= journalTagsDisplayContext.hasTags() %>">
				<c:if test="<%= journalTagsDisplayContext.hasOfficial() %>">
					<li>
						<span class="glyphicon glyphicon-check"></span>

						<a href="/search?assetTagNames=official">official</a>
					</li>
				</c:if>

				<li>
					<span class="glyphicon glyphicon-tags"></span>

					<%
					for (AssetTag tag : journalTagsDisplayContext.getUnofficialTags()) {
					%>

						<a href="/search?assetTagNames=<%= tag.getName() %>"><%= tag.getName() %></a>

					<%
					}
					%>

				</li>
			</c:if>
		</ul>
	</div>
</nav>