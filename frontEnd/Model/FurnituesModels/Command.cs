

using Model.GestionUser;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Command
    {
        [JsonProperty("commandId")]
        [Key]
        public long CommandId { get; set; }
        [JsonProperty("etat")]
        public string Etat { get; set; }
        [JsonProperty("date")]
        public DateTime Date { get; set; }
        [JsonProperty("total_price")]
        public float Total_price { get; set; }
        [JsonProperty("transporterValidation")]
        public Boolean TransporterValidation { get; set; }
        [JsonProperty("code")]
        public string Code { get; set; }

        // foreign Key properties

        public long TransportorId { get; set; }
        [JsonProperty("transporters")]
        public virtual Transportor MyTransporter { get; set; }


        public long UserId { get; set; }
        [JsonProperty("users")]
        public virtual UserDari MyUserDari { get; set; }

        public List<SoldFurniture> ListSoldFurnitures { get; set; }
    }
}