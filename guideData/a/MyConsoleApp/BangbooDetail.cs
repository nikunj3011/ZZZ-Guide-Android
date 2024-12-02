using Newtonsoft.Json;

public partial class BangbooDetail
    {
        [JsonProperty("componentChunkName")]
        public string ComponentChunkName { get; set; }

        [JsonProperty("path")]
        public string Path { get; set; }

        [JsonProperty("result")]
        public Result Result { get; set; }

        [JsonProperty("staticQueryHashes")]
        public List<object> StaticQueryHashes { get; set; }
    }

    public partial class Result
    {
        [JsonProperty("data")]
        public Data Data { get; set; }

        [JsonProperty("pageContext")]
        public PageContext PageContext { get; set; }
    }

    public partial class Data
    {
        [JsonProperty("currentUnit")]
        public CurrentUnit CurrentUnit { get; set; }
    }

    public partial class CurrentUnit
    {
        [JsonProperty("nodes")]
        public List<Node> Nodes { get; set; }
    }

    public partial class Node
    {
        [JsonProperty("id")]
        public Guid Id { get; set; }

        [JsonProperty("updatedAt")]
        public DateTimeOffset UpdatedAt { get; set; }

        [JsonProperty("createdAt")]
        public DateTimeOffset CreatedAt { get; set; }

        [JsonProperty("unitId")]
        public long UnitId { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("slug")]
        public string Slug { get; set; }

        [JsonProperty("rarity")]
        public string Rarity { get; set; }

        [JsonProperty("smallImage")]
        public Image SmallImage { get; set; }

        [JsonProperty("cardImage")]
        public Image CardImage { get; set; }

        [JsonProperty("statsNew")]
        public StatsNew StatsNew { get; set; }

        [JsonProperty("skills")]
        public Skills Skills { get; set; }
    }

    public partial class Image
    {
        [JsonProperty("localFile")]
        public LocalFile LocalFile { get; set; }
    }

    public partial class LocalFile
    {
        [JsonProperty("childImageSharp")]
        public ChildImageSharp ChildImageSharp { get; set; }
    }

    public partial class ChildImageSharp
    {
        [JsonProperty("gatsbyImageData")]
        public GatsbyImageData GatsbyImageData { get; set; }
    }

    public partial class GatsbyImageData
    {
        [JsonProperty("layout")]
        public string Layout { get; set; }

        [JsonProperty("backgroundColor")]
        public string BackgroundColor { get; set; }

        [JsonProperty("images")]
        public Images Images { get; set; }

        [JsonProperty("width")]
        public long Width { get; set; }

        [JsonProperty("height")]
        public long Height { get; set; }
    }

    public partial class Images
    {
        [JsonProperty("fallback")]
        public Fallback Fallback { get; set; }

        [JsonProperty("sources")]
        public List<Source> Sources { get; set; }
    }

    public partial class Fallback
    {
        [JsonProperty("src")]
        public string Src { get; set; }

        [JsonProperty("srcSet")]
        public string SrcSet { get; set; }

        [JsonProperty("sizes")]
        public string Sizes { get; set; }
    }

    public partial class Source
    {
        [JsonProperty("srcSet")]
        public string SrcSet { get; set; }

        [JsonProperty("type")]
        public string Type { get; set; }

        [JsonProperty("sizes")]
        public string Sizes { get; set; }
    }

    public partial class Skills
    {
        [JsonProperty("skill_a")]
        public Skill SkillA { get; set; }

        [JsonProperty("skill_b")]
        public SkillB SkillB { get; set; }

        [JsonProperty("skill_c")]
        public Skill SkillC { get; set; }
    }

    public partial class Skill
    {
        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("description")]
        public string Description { get; set; }

        [JsonProperty("base_multi")]
        public long? BaseMulti { get; set; }

        [JsonProperty("rank_multi")]
        public double? RankMulti { get; set; }

        [JsonProperty("static_multi")]
        public object StaticMulti { get; set; }

        [JsonProperty("daze")]
        public long? Daze { get; set; }

        [JsonProperty("daze_rank")]
        public double? DazeRank { get; set; }

        [JsonProperty("element")]
        public string Element { get; set; }

        [JsonProperty("cooldown")]
        public long? Cooldown { get; set; }
    }

    public partial class SkillB
    {
        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("element")]
        public string Element { get; set; }

        [JsonProperty("description")]
        public List<Description> Description { get; set; }
    }

    public partial class Description
    {
        [JsonProperty("desc")]
        public string Desc { get; set; }
    }

    public partial class StatsNew
    {
        [JsonProperty("hp")]
        public long Hp { get; set; }

        [JsonProperty("atk")]
        public long Atk { get; set; }

        [JsonProperty("def")]
        public long Def { get; set; }

        [JsonProperty("impact")]
        public long Impact { get; set; }

        [JsonProperty("anomaly")]
        public long Anomaly { get; set; }
    }

    public partial class PageContext
    {
        [JsonProperty("contentfulId")]
        public Guid ContentfulId { get; set; }
    }