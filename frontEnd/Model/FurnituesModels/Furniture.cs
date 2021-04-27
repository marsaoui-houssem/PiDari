using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Furniture
    {
        [JsonProperty("furnitureId")]
        [Key]
        public long FurnitureId { get; set; }
        [JsonProperty("name")]
        public string Name { get; set; }
        [JsonProperty("description")]
        public string Description { get; set; }
        [JsonProperty("price")]
        public float Price { get; set; }
        [JsonProperty("stock")]
        public int Stock { get; set; }
        [JsonProperty("weight")]
        public float Weight { get; set; }
        [JsonProperty("width")]
        public float Width { get; set; }
        [JsonProperty("height")]
        public float Height { get; set; }

        // foreign Key properties
        [JsonProperty("category")]
        public Category MyCategory { get; set; }
        public long? CategoryId { get; set; }

        public List<Basket> ListBaskets { get; set; }
    }
}