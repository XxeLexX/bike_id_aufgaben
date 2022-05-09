public class Bike {
    private String ride_id,rideable_type,started_at,ended_at,start_station_name,start_station_id,end_station_name,end_station_id,start_lat,start_lng,end_lat,end_lng,member_casual;

    public Bike() {
    }

    public Bike(String ride_id, String rideable_type, String started_at, String ended_at, String start_station_name, String start_station_id, String end_station_name, String end_station_id, String start_lat, String start_lng, String end_lat, String end_lng, String member_casual) {
        this.ride_id = ride_id;
        this.rideable_type = rideable_type;
        this.started_at = started_at;
        this.ended_at = ended_at;
        this.start_station_name = start_station_name;
        this.start_station_id = start_station_id;
        this.end_station_name = end_station_name;
        this.end_station_id = end_station_id;
        this.start_lat = start_lat;
        this.start_lng = start_lng;
        this.end_lat = end_lat;
        this.end_lng = end_lng;
        this.member_casual = member_casual;
    }

    public String getRide_id() {
        return ride_id;
    }

    public void setRide_id(String ride_id) {
        this.ride_id = ride_id;
    }

    public String getRideable_type() {
        return rideable_type;
    }

    public void setRideable_type(String rideable_type) {
        this.rideable_type = rideable_type;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(String ended_at) {
        this.ended_at = ended_at;
    }

    public String getStart_station_name() {
        return start_station_name;
    }

    public void setStart_station_name(String start_station_name) {
        this.start_station_name = start_station_name;
    }

    public String getStart_station_id() {
        return start_station_id;
    }

    public void setStart_station_id(String start_station_id) {
        this.start_station_id = start_station_id;
    }

    public String getEnd_station_name() {
        return end_station_name;
    }

    public void setEnd_station_name(String end_station_name) {
        this.end_station_name = end_station_name;
    }

    public String getEnd_station_id() {
        return end_station_id;
    }

    public void setEnd_station_id(String end_station_id) {
        this.end_station_id = end_station_id;
    }

    public String getStart_lat() {
        return start_lat;
    }

    public void setStart_lat(String start_lat) {
        this.start_lat = start_lat;
    }

    public String getStart_lng() {
        return start_lng;
    }

    public void setStart_lng(String start_lng) {
        this.start_lng = start_lng;
    }

    public String getEnd_lat() {
        return end_lat;
    }

    public void setEnd_lat(String end_lat) {
        this.end_lat = end_lat;
    }

    public String getEnd_lng() {
        return end_lng;
    }

    public void setEnd_lng(String end_lng) {
        this.end_lng = end_lng;
    }

    public String getMember_casual() {
        return member_casual;
    }

    public void setMember_casual(String member_casual) {
        this.member_casual = member_casual;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "ride_id='" + ride_id + '\'' +
                ", rideable_type='" + rideable_type + '\'' +
                ", started_at='" + started_at + '\'' +
                ", ended_at='" + ended_at + '\'' +
                ", start_station_name='" + start_station_name + '\'' +
                ", start_station_id='" + start_station_id + '\'' +
                ", end_station_name='" + end_station_name + '\'' +
                ", end_station_id='" + end_station_id + '\'' +
                ", start_lat='" + start_lat + '\'' +
                ", start_lng='" + start_lng + '\'' +
                ", end_lat='" + end_lat + '\'' +
                ", end_lng='" + end_lng + '\'' +
                ", member_casual='" + member_casual + '\'' +
                '}';
    }
}
