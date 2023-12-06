package use_case.query.query_all;

public class QueryAllInputData {
    private final String keywords;
    private  final int resultPerPage;
    public QueryAllInputData(String keywords, int resultPerPage) {
        this.keywords = keywords.trim();
        this.resultPerPage = resultPerPage;
    }

    public String getKeywords() {return keywords;}

    public int getResultPerPage() {return resultPerPage;}
}
