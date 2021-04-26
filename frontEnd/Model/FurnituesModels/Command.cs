

using Model.GestionUser;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Command
    {
        public long CommandId { get; set; }
        public string Etat { get; set; }
        public DateTime Date { get; set; }
        public float Total_price { get; set; }
        public Boolean TransporterValidation { get; set; }
        public string Code { get; set; }

        // foreign Key properties

        public long TransportorId { get; set; }
        public virtual Transportor MyTransporter { get; set; }


        public long UserId { get; set; }
        public virtual UserDari MyUserDari { get; set; }

        public List<SoldFurniture> ListSoldFurnitures { get; set; }
    }
}