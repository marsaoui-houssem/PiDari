using Model.GestionUser;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Model.FurnituresModels
{
    public class Basket
    {
        public long BasketId { get; set; }
        public int Quantity { get; set; }

        // foreign Key properties

        public long? FurnitureId { get; set; }

        public virtual Furniture MyFurniture { get; set; }


        public long UserId { get; set; }
        public virtual UserDari MyUserDari { get; set; }
    }
}