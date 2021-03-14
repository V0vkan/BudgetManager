package budget;

public class Analyzer {

    PurchasesLists lists = new PurchasesLists(Purchases.getFood(), Purchases.getClothes(), Purchases.getEntertainment(),
            Purchases.getOther());

    private AnalyzeMethod method;

    public void setMethod(AnalyzeMethod method) {
        this.method = method;
    }

    public void analyze() {
        this.method.analyze(lists);
    }

}
