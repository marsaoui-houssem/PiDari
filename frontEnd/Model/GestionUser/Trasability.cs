using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.GestionUser
{
   public class Trasability
    {

        [JsonProperty("id")]
        public long Id { get; set; }
        [JsonProperty("request")]
        public String Request { get; set; }

        [JsonProperty("date")]
        public DateTime Password { get; set; }
        [JsonProperty("user")]
        public String User { get; set; }

    }
}
