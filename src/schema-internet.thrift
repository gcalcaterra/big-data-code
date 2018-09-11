namespace php manning.schema
namespace java manning.schema


#Nodes
union InternetUseId {
	1: string id
}

union IndividualTypeId {
	1: string id
}

union GeographyId {
	1: string id
}


#Edges
struct FactsEdge {
	1: required InternetUseId	internetUse;
	2: required IndividualTypeId	individualType;
	3: required GeographyId		geography;
	4: String 	year;
	5: i64		units;		
}


#Properties
struct ConceptProperties {
	1: required String label;
	2: required String status;
	3: optional Date modified;
	4: optional String notation;
}

#InternetUse Properties
union InternetUsePropertyValue {
	1: ConceptProperties conceptProperties;
}

struct InternetUseProperty {
	1: required InternetUseId id;
	2: required InternetUsePropertyValue property;

#IndividualType Properties
union IndividualTypePropertyValue {
	1: ConceptProperties conceptProperties;
}

struc IndividualTypeProperty {
	1: required IndividualTypeId id;
	2: required IndividualTypePropertyValue property;
}

#Geography Properties
union GeographyPropertyValue {
	1: ConceptProperties conceptProperties;
}

struc GeographyProperty {
	1: required GeographyId id;
	2: required GeographyPropertyValue property;
}

#Tying everything together
union DataUnit {
	1: InternetUseProperty internetUseProperty;
	2: IndividualTypeProperty individualTypeProperty;
	3: GeographyProperty geographyProperty;
	4: FactsEdge factsEdge;
}

struct Pedigree {
	1: required i32 trueAsOfSecs;
}
struct Data {
	1: required Pedigree pedigree;
	2: required DataUnit dataUnit;
} 







