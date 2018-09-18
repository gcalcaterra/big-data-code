package tp1Parcial.test;


import com.sun.jersey.api.model.Parameter.Source;

import tp1Parcial.schema.*;

public class DataProcess {
	
//    public static Pedigree makePedigree(int timeSecs) {
//        return new Pedigree(timeSecs,
//                Source.SELF,
//                OrigSystem.page_view(new PageViewSystem())
//        );
//
//    }
    


	public static Pedigree makePedigree(int timeSecs) {
    	return new Pedigree(timeSecs);
    }

    
    public static Data makeFacts(int timeSecs, InternetUseId internetUseId, IndividualTypeId individualType, GeographyId geography, String year, int units) {
    	return new Data(makePedigree(timeSecs),
    			DataUnit.factsEdge(
    					new FactsEdge(internetUseId, individualType, geography, year, units)
    				));
	}
    
//    public static tp1Parcial.schema.Data makePageview(int userid, String url, int timeSecs) {
//        return new tp1Parcial.schema.Data(makePedigree(timeSecs),
//                DataUnit.page_view(
//                        new PageViewEdge(
//                                PersonID.user_id(userid),
//                                PageID.url(url),
//                                1
//                        )));
//    }
//
//    public static tp1Parcial.schema.Data makeEquiv(int user1, int user2) {
//        return new tp1Parcial.schema.Data(makePedigree(1000),
//                DataUnit.equiv(
//                        new EquivEdge(
//                                PersonID.user_id(user1),
//                                PersonID.user_id(user2)
//                        )));
//    }


}
