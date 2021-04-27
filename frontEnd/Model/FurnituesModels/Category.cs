using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Category
    {
        [JsonProperty("categoryId")]
        [Key]
        public long CategoryId { get; set; }
        [JsonProperty("name")]
        public String Name { get; set; }
        [JsonProperty("description")]
        public String Description { get; set; }
        public ICollection<Furniture> furnitures { get; set; }

    }
}