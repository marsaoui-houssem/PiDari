using Model.GestionUser;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class GiftPoints
    {
        [JsonProperty("giftpointsId")]
        [Key]
        public long GiftpointsId { get; set; }
        [JsonProperty("points")]
        public int Points { get; set; }
        [JsonProperty("etat")]
        public string Etat { get; set; }
        [JsonProperty("code")]
        public string Code { get; set; }
        [JsonProperty("begin_date")]
        public DateTime Begin_date { get; set; }
        [JsonProperty("end_date")]
        public DateTime End_date { get; set; }
        [JsonProperty("value")]
        public float Value { get; set; }

        // foreign Key properties

        public long UserId { get; set; }
        [JsonProperty("users")]
        public virtual UserDari MyUserDari { get; set; }
    }
}