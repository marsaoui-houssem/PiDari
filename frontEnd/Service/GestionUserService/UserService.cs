
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;

using Model.GestionUser;

namespace Service
{
   public  class UserService
    {
        HttpClient httpClient;
        public UserService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

        }

       

        public UserDari GetById(long id)
        {

            UserDari user = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "useradmin/findUser/" + id).Result;

            if (response.IsSuccessStatusCode)
            {
                var u = response.Content.ReadAsAsync<UserDari>().Result;

                return u;
            }


            return user;

        }

        public bool DeleteUser(int id)
        {

            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "getAllUsers/" + id);

                return true;
            }
            catch
            {
                return false;
            }


        }

    }
}
