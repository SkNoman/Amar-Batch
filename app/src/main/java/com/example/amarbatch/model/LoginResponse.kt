data class LoginResponse(
	val loginResponse: List<LoginResponseItem?>? = null
)

data class LinksItem(
	val rel: String? = null,
	val href: String? = null
)

data class LoginResponseItem(
	val offset: Int? = null,
	val hasMore: Boolean? = null,
	val limit: Int? = null,
	val count: Int? = null,
	val links: List<LinksItem?>? = null,
	val items: List<ItemsItem?>? = null
)

data class ItemsItem(
	val password: String? = null,
	val userName: String? = null
)

