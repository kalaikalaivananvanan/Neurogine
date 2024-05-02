public class Store {

    private String id; 
    private String storeType;
    private String name;
    private Location location;
    private double distance;
    private double rating;
    private long drivingTime; 
    private double deliveryCost;
    private List<Offer> offers;


    public static class Location {
        private double longitude;
        private double latitude;

    }

    public static class Offer {
        private String title;
        private String description;
        private Date startDate;
        private Date endDate;

    }
}
