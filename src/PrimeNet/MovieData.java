package PrimeNet;


import java.util.List;

public class MovieData {

    private class Results {
        private String title;
        private String overview;
        private  String release_date;
        private String poster_path;
        private String id;
    }

    private List<Results> results;

    public String getTitle() {
        return results.get(0).title;
    }

    public String getOverview() {
        return results.get(0).overview;
    }

    public String getReleaseDate() {
        return results.get(0).release_date;
    }

    public String getMovieID() {
        return results.get(0).id;
    }

    public String getPosterpath() {
        return "https://api.themoviedb.org/3/movie/" + results.get(0).id + "/images" + results.get(0).poster_path + ".jpg";
    }

}

/* Example JSON
{"page":1,"total_results":1,"total_pages":1,
"results":[{"vote_count":4943,
"id":497,
"video":false,
"vote_average":8.3,"title":"The Green Mile",
"popularity":32.818983,
"poster_path":"\/3yJUlOtVa09CYJocwBU8eAryja0.jpg",
"original_language":"en",
"original_title":"The Green Mile",
"genre_ids":[14,18,80],
"backdrop_path":"\/Rlt20sEbOQKPVjia7lUilFm49W.jpg",
"adult":false,
"overview":"A supernatural tale set on death row in a Southern prison, where gentle giant John Coffey possesses
the mysterious power to heal people's ailments. When the cellblock's head guard, Paul Edgecomb, recognizes Coffey's
miraculous gift, he tries desperately to help stave off the condemned man's execution.",
"release_date":"1999-12-10"}]}
*/
