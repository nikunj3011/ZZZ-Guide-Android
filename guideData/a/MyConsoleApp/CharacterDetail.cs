using System;
using System.Collections.Generic;

using System.Globalization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

public partial class CharacterDetail
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

public partial class Data2
{
    [JsonProperty("currentUnit")]
    public CurrentUnit2 CurrentUnit { get; set; }
}

public partial class CurrentUnit2
{
    [JsonProperty("nodes")]
    public List<Node2> Nodes { get; set; }
}

public partial class Node2
{
    [JsonProperty("id")]
    public Guid Id { get; set; }

    [JsonProperty("updatedAt")]
    public string UpdatedAt { get; set; }

    [JsonProperty("createdAt")]
    public DateTimeOffset CreatedAt { get; set; }

    [JsonProperty("unitId")]
    public long UnitId { get; set; }

    [JsonProperty("name")]
    public string Name { get; set; }

    [JsonProperty("skillKey")]
    public string SkillKey { get; set; }

    [JsonProperty("fullName")]
    public string FullName { get; set; }

    [JsonProperty("slug")]
    public string Slug { get; set; }

    [JsonProperty("rarity")]
    public string Rarity { get; set; }

    [JsonProperty("smallImage")]
    public Image SmallImage { get; set; }

    [JsonProperty("cardImage")]
    public Image CardImage { get; set; }

    [JsonProperty("faction")]
    public string Faction { get; set; }

    [JsonProperty("attackType")]
    public List<string> AttackType { get; set; }

    [JsonProperty("style")]
    public string Style { get; set; }

    [JsonProperty("element")]
    public string Element { get; set; }

    [JsonProperty("review")]
    public Cons Review { get; set; }

    [JsonProperty("pros")]
    public Cons Pros { get; set; }

    [JsonProperty("cons")]
    public Cons Cons { get; set; }

    [JsonProperty("videos")]
    public List<Video> Videos { get; set; }

    [JsonProperty("endgameStats")]
    public Cons EndgameStats { get; set; }

    [JsonProperty("tierListCategory")]
    public string TierListCategory { get; set; }

    [JsonProperty("tierListTags")]
    public List<string> TierListTags { get; set; }

    [JsonProperty("ratings")]
    public Ratings Ratings { get; set; }

    [JsonProperty("build")]
    public Build Build { get; set; }

    [JsonProperty("talents")]
    public List<Talent> Talents { get; set; }

    [JsonProperty("introduction")]
    public object Introduction { get; set; }

    [JsonProperty("voiceActors")]
    public VoiceActors VoiceActors { get; set; }

    [JsonProperty("releaseDate")]
    public string ReleaseDate { get; set; }

    [JsonProperty("upcoming")]
    public bool? Upcoming { get; set; }
}

public partial class Build
{
    [JsonProperty("main_4")]
    public List<Main> Main4 { get; set; }

    [JsonProperty("main_5")]
    public List<Main> Main5 { get; set; }

    [JsonProperty("main_6")]
    public List<Main> Main6 { get; set; }

    [JsonProperty("sets")]
    public object Sets { get; set; }

    [JsonProperty("engines")]
    public List<Engine> Engines { get; set; }

    [JsonProperty("substats")]
    public string Substats { get; set; }
}

public partial class Engine
{
    [JsonProperty("super")]
    public long Super { get; set; }

    [JsonProperty("weapon")]
    public string Weapon { get; set; }

    [JsonProperty("percent")]
    public string Percent { get; set; }

    [JsonProperty("percent_standard")]
    public string PercentStandard { get; set; }

    [JsonProperty("notes")]
    public object Notes { get; set; }
}

public partial class Main
{
    [JsonProperty("stat")]
    public string Stat { get; set; }

    [JsonProperty("sign")]
    public string Sign { get; set; }
}

public partial class Cons
{
    [JsonProperty("raw")]
    public string Raw { get; set; }
}

public partial class Ratings
{
    [JsonProperty("shiyu")]
    public long Shiyu { get; set; }
}

public partial class Talent
{
    [JsonProperty("name")]
    public string Name { get; set; }

    [JsonProperty("desc")]
    public string Desc { get; set; }
}

public partial class Video
{
    [JsonProperty("video")]
    public string VideoVideo { get; set; }
}

public partial class VoiceActors
{
    [JsonProperty("en")]
    public string En { get; set; }

    [JsonProperty("kr")]
    public string Kr { get; set; }

    [JsonProperty("jpn")]
    public string Jpn { get; set; }

    [JsonProperty("cn")]
    public string Cn { get; set; }
}

public partial class PageContext2
{
    [JsonProperty("contentfulId")]
    public Guid ContentfulId { get; set; }
}