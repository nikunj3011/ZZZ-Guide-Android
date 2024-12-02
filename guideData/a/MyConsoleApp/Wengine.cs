namespace Wengine
{
    using System;
    using System.Collections.Generic;

    using System.Globalization;
    using Newtonsoft.Json;
    using Newtonsoft.Json.Converters;

public partial class WengineDetail
    {
        [JsonProperty("componentChunkName")]
        public string ComponentChunkName { get; set; }

        [JsonProperty("path")]
        public string Path { get; set; }

        [JsonProperty("result")]
        public Result Result { get; set; }

        [JsonProperty("staticQueryHashes")]
        public List<long> StaticQueryHashes { get; set; }
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
        [JsonProperty("allCharacters")]
        public AllCharacters AllCharacters { get; set; }
    }

    public partial class AllCharacters
    {
        [JsonProperty("nodes")]
        public List<Node> Nodes { get; set; }
    }

    public partial class Node
    {
        [JsonProperty("engineId")]
        public long EngineId { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("rarity")]
        public Rarity Rarity { get; set; }

        [JsonProperty("talentName")]
        public string TalentName { get; set; }

        [JsonProperty("element")]
        public string Element { get; set; }

        [JsonProperty("type")]
        public NodeType Type { get; set; }

        [JsonProperty("image")]
        public Image Image { get; set; }

        [JsonProperty("description")]
        public Description Description { get; set; }

        [JsonProperty("stats")]
        public Stats Stats { get; set; }
    }

    public partial class Description
    {
        [JsonProperty("raw")]
        public string Raw { get; set; }
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
        public Layout Layout { get; set; }

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

    public partial class Stats
    {
        [JsonProperty("stat")]
        public string Stat { get; set; }

        [JsonProperty("base_atk")]
        public long BaseAtk { get; set; }

        [JsonProperty("max_atk")]
        public long MaxAtk { get; set; }

        [JsonProperty("base_special")]
        public string BaseSpecial { get; set; }

        [JsonProperty("max_special")]
        public string MaxSpecial { get; set; }
    }

    public partial class PageContext
    {
    }

    public enum BackgroundColor { F8F8F8, The080808 };

    public enum Sizes { MinWidth156Px156Px100Vw, MinWidth256Px256Px100Vw, MinWidth400Px400Px100Vw };

    public enum SourceType { ImageWebp };

    public enum Layout { Constrained };

    public enum Rarity { A, B, S };

    public enum NodeType { Anomaly, Attack, Defence, Stun, Support };
}