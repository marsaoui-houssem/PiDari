using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.Abonnement
{


    public enum TypeService { InternetTv, Menagement, Bricolage, TransportImobilier }
   public  class OffreService
    {


        [JsonProperty("idServ")]
        [Key]
        public int idServ { get; set; }

        [JsonProperty("nomServ")]
        public string nomServ { get; set; }

        [JsonProperty("descSer")]
        public string descSer { get; set; }

        [JsonProperty("dureService")]
        public string dureService { get; set; }

        [JsonProperty("prixServ")]
        public float prixServ { get; set; }

        [JsonProperty("datedebutService")]
        [DataType(DataType.Date)]
        public DateTime datedebutService { get; set; }

        [JsonProperty("dateFintService")]
        [DataType(DataType.Date)]
        public DateTime dateFintService { get; set; }

        [JsonProperty("typeservice")]
        public TypeService typeservice { get; set; }

        [JsonProperty("services")]
        public virtual Abonnement ServAbon { get; set; }

    }
}
