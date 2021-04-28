using Model.GestionUser;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.Abonnement
{
    public enum TypeAbon { Server, Gold, Premium }

   public  class Abonnement
    {




        [Key]
        [JsonProperty("idAbon")]
        public int idAbon { get; set; }

        [JsonProperty("nomAbon")]
        public string nomAbon { get; set; }

        [JsonProperty("descriptionAbon")]
        public string descriptionAbon { get; set; }

        [JsonProperty("typeAbon")]
        public TypeAbon typeAbon { get; set; }

        [JsonProperty("dureAbonn")]
        public string dureAbonn { get; set; }


        [JsonProperty("dateDebut")]
        [DataType(DataType.Date)]
        public DateTime DateDebut { get; set; }


        [JsonProperty("datefint")]
        [DataType(DataType.Date)]
        public DateTime Datefint { get; set; }


        [JsonProperty("prix")]
        public float prix { get; set; }

      //  [JsonProperty("assurences")]
        public virtual List<Assurence> Assurences { get; set; }

      //  [JsonProperty("services")]
        public virtual List<OffreService> OffreServices { get; set; }


        public virtual UserDari userDari { get; set; }

    }
}
