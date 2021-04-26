using Model.FurnituresModels;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Model.GestionUser
{
   public class UserDari
    {
        [JsonProperty("id")]
        [Key]
        public long userId { get; set; }
        [JsonProperty("firstName")]
        public String FirstName { get; set; }
        [JsonProperty("lastName")]
        public String LastName { get; set; }
        [JsonProperty("email")]
        public String Email { get; set; }
        [JsonProperty("password")]
        public String Password { get; set; }
        [JsonProperty("PhoneNumber")]
        public String PhoneNumber { get; set; }
        [JsonProperty("activated")]
        public Boolean Activated { get; set; }
        [JsonProperty("imageUrl")]
        public String ImageUrl { get; set; }
        [JsonProperty("roleDaris")]
        public virtual ICollection<RoleDari> RoleDaris{ get; set; }
        [JsonProperty("giftPoints")]
        public List<GiftPoints> ListGiftPoints { get; set; }
        [JsonProperty("baskets")]
        public List<Basket> ListBaskets { get; set; }
        [JsonProperty("commands")]
        public List<Command> ListCommands { get; set; }

    }
}
