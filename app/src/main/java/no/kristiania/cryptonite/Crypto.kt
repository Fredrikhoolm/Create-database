package no.kristiania.cryptonite

    class Crypto(val data: List<Data>)

   class Data(
    val changePercent24Hr: Double,
    val explorer: String?,
    val id: String?,
    val marketCapUsd: String?,
    val maxSupply: String?,
    val name: String?,
    val priceUsd: Double,
    val rank: String?,
    val supply: String?,
    val symbol: String?,
    val volumeUsd24Hr: String?,
    val vwap24Hr: String?
)