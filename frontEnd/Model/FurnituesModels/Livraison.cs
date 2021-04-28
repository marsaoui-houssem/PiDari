using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Livraison
    {
        [JsonProperty("id")]
        [Key]
        public long LivraisonId { get; set; }
        [JsonProperty("kiloPrice")]
        public float KiloPrice { get; set; }
    }
}