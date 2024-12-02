using Newtonsoft.Json;
public partial class Bangboo
    {
        [JsonProperty("componentChunkName")]
        public string ComponentChunkName { get; set; }

        [JsonProperty("path")]
        public string Path { get; set; }

        [JsonProperty("result")]
        public Result Result { get; set; }

        [JsonProperty("staticQueryHashes")]
        public List<string> StaticQueryHashes { get; set; }
    }


    public partial class Data
    {
        [JsonProperty("allCharacters")]
        public AllCharacters AllCharacters { get; set; }
    }

    public partial class AllCharacters
    {
        [JsonProperty("nodes")]
        public List<Node> Nodes { get; set; }
    }
    
    public partial class PageContext
    {
    }

    public enum Rarity { A, S };
