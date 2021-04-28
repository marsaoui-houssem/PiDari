using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Transportor
    {
        [JsonProperty("transporterId")]
        [Key]
        public long TransportorId { get; set; }
        [JsonProperty("firstname")]
        public string Firstname { get; set; }
        [JsonProperty("lastname")]
        public string Lastname { get; set; }
        [JsonProperty("dateofbirth")]
        public DateTime Dateofbirth { get; set; }
        [JsonProperty("phone_number")]
        public int Phone_number { get; set; }
        [JsonProperty("secteur")]
        public string Secteur { get; set; }

        public List<Command> ListCommands { get; set; }
    }
}