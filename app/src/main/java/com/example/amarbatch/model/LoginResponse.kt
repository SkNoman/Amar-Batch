package com.example.amarbatch.model

data class LoginResponse(
	val offset: Int,
	val hasMore: Boolean,
	val limit: Int,
	val count: Int,
	val links: List<LinksItem>,
	val items: List<ItemsItem>
)
