using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.GestionUser
{
   public class Tokken
    {
        [JsonProperty("username")]
        public String UserName { get; set; }

        [JsonProperty("password")]
        public String Password { get; set; }
    }
}
