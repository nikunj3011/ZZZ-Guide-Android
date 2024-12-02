using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace JsonMerger
{
    class Program
    {
        static async Task Main(string[] args)
        {
            //bangboos
            string url1 = "https://www.prydwen.gg/page-data/zenless/bangboo/page-data.json";
            var bangboos = new List<BangbooDetail>();
            var bangboosnew = new List<Node>();
            // Fetch the initial JSON data
            using (HttpClient client = new HttpClient())
            {
                var response = await client.GetStringAsync(url1);
                var initialJson = JsonConvert.DeserializeObject<Bangboo>(response);
                foreach (var slug in initialJson.Result.Data.AllCharacters.Nodes)
                {
                    var newresponse = await client.GetStringAsync($"https://www.prydwen.gg/page-data/zenless/bangboo/{slug.Slug}/page-data.json");
                    var c = JsonConvert.DeserializeObject<BangbooDetail>(newresponse);
                    bangboos.Add(c);
                    bangboosnew.Add(c.Result.Data.CurrentUnit.Nodes.First());
                }
            }
            string jsonString = JsonConvert.SerializeObject(bangboosnew, Formatting.Indented);
            File.WriteAllText(@"C:\Users\nikunj.rathod\Documents\Learning\ZZZ-Guide-Android\guideData\bangboosNew.json", jsonString);
            // Console.WriteLine(jsonString);

            //characters
            string url2 = "https://www.prydwen.gg/page-data/zenless/characters/page-data.json";
            var characters = new List<CharacterDetail>();
            var charsnew = new List<Node2>();
            // Fetch the initial JSON data
            using (HttpClient client = new HttpClient())
            {
                var response = await client.GetStringAsync(url2);
                var initialJson = JsonConvert.DeserializeObject<Character>(response);
                foreach (var slug in initialJson.Result.Data.AllCharacters.CharacterNodes)
                {
                    var newresponse = await client.GetStringAsync($"https://www.prydwen.gg/page-data/zenless/characters/{slug.Slug}/page-data.json");
                    var c = JsonConvert.DeserializeObject<CharacterDetail>(newresponse);
                    characters.Add(c);
                    charsnew.Add(c.Result.Data.CurrentUnit.Nodes.First());
                }
            }
            string jsonString2 = JsonConvert.SerializeObject(charsnew, Formatting.Indented);
            File.WriteAllText(@"C:\Users\nikunj.rathod\Documents\Learning\ZZZ-Guide-Android\guideData\charactersdetail\charactersDetails.json", jsonString2);


            //wengines
            string url3 = "https://www.prydwen.gg/page-data/zenless/w-engines/page-data.json";
            var wengines = new List<Wengine.WengineDetail>();
            var wenginesDet = new List<Wengine.Node>();
            // Fetch the initial JSON data
            using (HttpClient client = new HttpClient())
            {
                var response = await client.GetStringAsync(url3);
                var initialJson = JsonConvert.DeserializeObject<Wengine.WengineDetail>(response);
                foreach (var slug in initialJson.Result.Data.AllCharacters.Nodes)
                {
                    wenginesDet.Add(slug);
                }
            }
            string jsonString3 = JsonConvert.SerializeObject(wenginesDet, Formatting.Indented);
            File.WriteAllText(@"C:\Users\nikunj.rathod\Documents\Learning\ZZZ-Guide-Android\guideData\wenginesNew.json", jsonString3);
        }
    }
}
