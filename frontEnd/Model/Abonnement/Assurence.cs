using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.Abonnement
{
   public  enum TypeAssurence { Multirisque, LoyerImpaye, Combriolages }
   public  class Assurence
    {

        [JsonProperty("idAssu")]
        [Key]
        public int idAssu { get; set; }

        [JsonProperty("nomAssu")]
        public string nomAssu { get; set; }


        [JsonProperty("descAssu")]
        public string descAssu { get; set; }

        [JsonProperty("dureAssu")]
        public string dureAss { get; set; }

        [JsonProperty("dateDebutAssu")]
        [DataType(DataType.Date)]
        public DateTime dateDeburAssu { get; set; }

        [JsonProperty("dateFintAssu")]
        [DataType(DataType.Date)]
        public DateTime dateFintAssu { get; set; }

        [JsonProperty("prixAss")]
        public float prixAss { get; set; }

        [JsonProperty("typeAssurence")]
        public TypeAssurence TypeAssurence { get; set; }



        [JsonProperty("assurences")]
        public virtual Abonnement AssAbon { get; set; }

    }
}
