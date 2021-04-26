using Model.GestionUser;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class GiftPoints
    {
        public long GiftpointsId { get; set; }
        public int Points { get; set; }
        public string Etat { get; set; }
        public string Code { get; set; }
        public DateTime Begin_date { get; set; }
        public DateTime End_date { get; set; }
        public float Value { get; set; }

        // foreign Key properties

        public long UserId { get; set; }
        public virtual UserDari MyUserDari { get; set; }
    }
}