using System;
using System.Collections.Generic;

using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;

using Model.Abonnement;
using Model.GestionUser;

namespace Service.AbonnementService
{
   public  class AbonnementService
    {
        HttpClient httpClient;



        public AbonnementService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            //httpClient.DefaultRequestHeaders.Add("Authorization", String.Format("Bearer{0}", Statics._AccessToken));
        }



        public IEnumerable<Abonnement> getAllAbon()
        {

            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/getAllAbon").Result;
            if (response.IsSuccessStatusCode)
            {
                var Abonnement = response.Content.ReadAsAsync<IEnumerable<Abonnement>>().Result;
                return Abonnement;
            }
            return new List<Abonnement>();


        }

            public Abonnement getAbonnById(int id)
        {
            Abonnement Abonnement = null; 
            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/getAbonnById/" + id).Result;

            if (response.IsSuccessStatusCode)
            {
                var e = response.Content.ReadAsAsync<Abonnement>().Result;
                return e;
            }
                return Abonnement; 
        }




        public Boolean ajoutAbonn(Abonnement ab)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<Abonnement>(Statics.baseAddress+ "Abonnement/ajouterAbonn",ab).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool affecteruserAabon(Abonnement abonnement, int userId)
        {

            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Abonnement>(Statics.baseAddress + "Abonnement/affecteruserAabon/" + userId + abonnement.idAbon ,
                 abonnement).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());

                System.Diagnostics.Debug.WriteLine(APIResponse.Result);

                return true;
            }
            catch
            {
                return false;
            }

        }


 


        public bool deleteAbonn(int id)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "Abonnement/deleteAbon/" + id);
                return true;
            }
            catch
            {
                return false;
            }
        }


        public IEnumerable<Assurence> getAllAssubyAbon(int idAbon)
        {

            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/getAllAssubyAbon/"+ idAbon).Result;
            if (response.IsSuccessStatusCode)
            {
                var Assurence = response.Content.ReadAsAsync<IEnumerable<Assurence>>().Result;
                return Assurence;
            }
            return new List<Assurence>();


        }

        public IEnumerable<OffreService> getAllServbyAbon(int idAbon)
        {

            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/getAllAssubyAbon/" + idAbon).Result;
            if (response.IsSuccessStatusCode)
            {
                var OffreService = response.Content.ReadAsAsync<IEnumerable<OffreService>>().Result;
                return OffreService;
            }
            return new List<OffreService>();


        }

   



        public IEnumerable<DateTime>  getAllDatefint() // mazelet  /getAllDatefint 
        {
            return new List<DateTime>();
        }


        public bool mettreAjourdatefinByAbon(int idAbon, Abonnement Abonnement)
        {

            try   
            {
                var APIResponse = httpClient.PutAsJsonAsync<Abonnement>(Statics.baseAddress + "Abonnement/mettreAjourdatefinByAbon/"+Abonnement.Datefint+"/"+idAbon, Abonnement).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
              
                return true;
            }
            catch
            {
                return false;
            }

        }

        // public String CaracteristiqueAbonne(int idAbon  )
        // {

        // var response = httpClient.GetStringAsync(Statics.baseAddress + "Abonnement/CaracteristiqueAbonne/" + idAbon).Result;

        // String carac = response.Content.ReadAsStringAsync().ToString();
        // return carac;


        //  }

          public float  prixAbonRemise( int idAbon)
        {
            float prixR = 0;

            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/prixAbonRemise/" + idAbon).Result;

            if (response.IsSuccessStatusCode)
            {
                var prix  = response.Content.ReadAsAsync<float>().Result;
                return prix ;
            }


            return prixR; 
        }




        public bool   mettreAjourPrixRemise( int idAbon)
        {
            try
            {
                //var APIResponse = httpClient.PutAsJsonAsync<Abonnement>(Statics.baseAddress + "Abonnement/mettreAjourPrixRemise/" + idAbon).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
              //  System.Diagnostics.Debug.WriteLine(APIResponse.Result);
               
                return true;
            }
            catch
            {
                return false;
            }

        }


        // public IEnumerable<> getAllAdByuser( Long userId  )   // mazel ma3andich el ad 
        // {
        //   var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/getAllAdByuser", userId ).Result;
        //    if (response.IsSuccessStatusCode)
        //    {
        ///        var club = response.Content.ReadAsAsync<IEnumerable<Club>>().Result;
        //         return club;
        //    }
        //   return new List<Club>();
        //   } 



        public String conseilleAchatAbon(long userId)
        {

            String conseille = null;  

            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/conseilleAchatAbon/" + userId).Result;

            if (response.IsSuccessStatusCode)
            {
                var prix = response.Content.ReadAsStringAsync().ToString();          //Content.ReadAsAsync<String>().Result;
                return prix;
            }


            return conseille;
       }


        public String meilleurVenteAbon()
        {

            String meilleur = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "Abonnement/meilleurVenteAbon/").Result;

            if (response.IsSuccessStatusCode)
            {
                var m = response.Content.ReadAsStringAsync().ToString();    //Content.ReadAsAsync<String>().Result;
                return m;
            }


            return meilleur;
        }










    }
}
