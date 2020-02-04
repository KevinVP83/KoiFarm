package be.hogent.koifarm.koifarm;

import java.math.BigDecimal;
import java.util.*;

public class KoiFarm {
    private String name;
    private String address;
    private Set<KoiSeller> sellerCollection = new HashSet<>();
    private Set<KoiKeeper> keeperCollection = new HashSet<>();
    private Set<Koi> koiCollection = new HashSet<>();
    private Map<Koi, BigDecimal> koiPriceMap = new HashMap<>();

    public Set<KoiSeller> getSellerCollection() {
        return sellerCollection;
    }

    public Set<KoiKeeper> getKeeperCollection() {
        return keeperCollection;
    }

    public KoiFarm(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void buy(Koi koi, BigDecimal price) {
        if (koiPriceMap.containsKey(koi)) {
            throw new IllegalStateException();
        }
        getKoiPriceMap().put(koi,price);
        getKoiCollection().add(koi);
    }

    public void sell(Koi koi, KoiSeller seller, KoiKeeper keeper, BigDecimal price) {
        if (!(koiCollection.contains(koi)) || !(sellerCollection.contains(seller))) {
            throw new NoSuchElementException();
        }
        Sale sale = new Sale();
        keeper.addKoi(koi);
        sale.addSaleItem(new SaleItem(koi,price));
        seller.getCompletedSales().add(sale);
        koiCollection.remove(koi);
    }

    public void sell(Map<Koi, BigDecimal> koiSale, KoiSeller seller, KoiKeeper keeper) {
        if ( !(koiCollection.containsAll(koiSale.keySet())) || !(sellerCollection.contains(seller))) {
            throw new NoSuchElementException();
        }
        Sale sale = new Sale();
        keeper.addKois(koiSale.keySet());
        sale.addSaleItems(koiSale);
        seller.getCompletedSales().add(sale);
        koiCollection.removeAll(koiSale.keySet());
    }

    public void addSeller(KoiSeller seller) {
        getSellerCollection().add(seller);
    }

    public void addKeeper(KoiKeeper keeper) {
        getKeeperCollection().add(keeper);
    }

    public Map getKoiPriceMap() {
        return koiPriceMap;
    }

    public Set<Koi> getKoiCollection() {
        return koiCollection;
    }

    public List getKoisSoldBySeller(KoiSeller seller) {
        return seller.getCompletedSales();
    }

    public BigDecimal getBoughtPrice(Koi koi) {
        if (!(koiPriceMap.containsKey(koi))) {
            throw new NoSuchElementException();
        }
        return koiPriceMap.get(koi);
    }

    public BigDecimal getBenefitsDoneBySeller(KoiSeller seller) {
        BigDecimal buyPrices = new BigDecimal(0);
        BigDecimal sellPrices = new BigDecimal(0);
        List<Sale> sales = getKoisSoldBySeller(seller);
        for (Sale sale : sales) {
            sellPrices = sellPrices.add(sale.getTotalPrice());
            for (SaleItem saleItem : sale.getTransactions()) {
                buyPrices = buyPrices.add(getBoughtPrice(saleItem.getKoi()));
            }
        }
        return sellPrices.subtract(buyPrices);
    }
}
