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
	<input class="activate hidden" id="contributors" name="contributors" type="checkbox" />

	<label class="accordion-label" for="contributors">Contributors</label>

	<div class="a-content sbox">
		<ul class="list-unstyled">

			<li>
				<table class="contributors-table">
					<c:if test="<%= modifierContributor != null %>">
						<tr>
							<td>
								<span class="glyphicon glyphicon-user"></span>
								Updated by <%= modifierContributor.getName() %>
							</td>
							<td class="last-td">
								<span class="glyphicon glyphicon-calendar"></span>
								<%= journalContributorsDisplayContext.getModifiedDate() %>
							</td>
						</tr>
					</c:if>

					<c:if test="<%= creatorContributor != null %>">
						<tr>
							<td>
								<span class="glyphicon glyphicon-user"></span>
								Creator: <%= creatorContributor.getName() %>
							</td>
							<td class="last-td">
								<span class="glyphicon glyphicon-calendar"> </span>
								<%= journalContributorsDisplayContext.getCreateDate() %>
							</td>
						</tr>
					</c:if>
				</table>
			</li>
		</ul>
	</div>
</nav>