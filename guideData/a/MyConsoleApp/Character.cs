using Newtonsoft.Json;
public partial class Character
    {
        [JsonProperty("componentChunkName")]
        public string ComponentChunkName { get; set; }

        [JsonProperty("path")]
        public string Path { get; set; }

        [JsonProperty("result")]
        public Result2 Result { get; set; }

        [JsonProperty("staticQueryHashes")]
        public List<string> StaticQueryHashes { get; set; }
    }

    public partial class Result2
    {
        [JsonProperty("data")]
        public Data2 Data { get; set; }

        [JsonProperty("pageContext")]
        public PageContext PageContext { get; set; }
    }
    public partial class Data2
    {
        [JsonProperty("allCharacters")]
        public AllCharacters2 AllCharacters { get; set; }
    }

    public partial class AllCharacters2
    {
        [JsonProperty("nodes")]
        public List<CharacterNode> CharacterNodes { get; set; }
    }

    public partial class CharacterNode
    {
        [JsonProperty("id")]
        public Guid Id { get; set; }

        [JsonProperty("unitId")]
        public long UnitId { get; set; }

        [JsonProperty("slug")]
        public string Slug { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("element")]
        public string Element { get; set; }

        [JsonProperty("rarity")]
        public string Rarity { get; set; }

        [JsonProperty("faction")]
        public string Faction { get; set; }

        [JsonProperty("style")]
        public Style Style { get; set; }
    }

    public partial class PageContext
    {
    }

    public enum Style { Anomaly, Attack, Defence, Stun, Support };
