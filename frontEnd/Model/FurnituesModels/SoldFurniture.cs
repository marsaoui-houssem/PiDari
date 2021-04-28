using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class SoldFurniture
    {
        [JsonProperty("soldfurnitureId")]
        [Key]
        public long SoldfurnitureId { get; set; }
        [JsonProperty("price")]
        public float Price { get; set; }
        [JsonProperty("name")]
        public string Name { get; set; }
        [JsonProperty("quantity")]
        public int Quantity { get; set; }


        // foreign Key properties

        public long? CommandId { get; set; }
        [JsonProperty("commands")]
        public virtual Command MyCommand { get; set; }
    }
}