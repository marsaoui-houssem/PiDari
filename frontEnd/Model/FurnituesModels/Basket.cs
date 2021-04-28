using Model.GestionUser;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Basket
    {
        [JsonProperty("basketId")]
        [Key]
        public long BasketId { get; set; }
        [JsonProperty("quantity")]
        public int Quantity { get; set; }

        // foreign Key properties

        public long? FurnitureId { get; set; }

        [JsonProperty("furnitures")]
        public virtual Furniture MyFurniture { get; set; }


        public long UserId { get; set; }

        [JsonProperty("users")]
        public virtual UserDari MyUserDari { get; set; }
    }
}