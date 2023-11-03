import java.util.ArrayList;
import java.util.List;

class Seat {
    private int seatNumber;
    private boolean isOccupied;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void vacate() {
        isOccupied = false;
    }
}

class CinemaHall {
    private List<Seat> seats;

    public CinemaHall(int numSeats) {
        seats = new ArrayList<>();
        for (int i = 1; i <= numSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

class MovieSession {
    private String movieName;
    private int duration; // in minutes
    private String time;
    private CinemaHall cinemaHall;

    public MovieSession(String movieName, int duration, String time, CinemaHall cinemaHall) {
        this.movieName = movieName;
        this.duration = duration;
        this.time = time;
        this.cinemaHall = cinemaHall;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDuration() {
        return duration;
    }

    public String getTime() {
        return time;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }
}

class Cinema {
    private String name;
    private List<CinemaHall> cinemaHalls;
    private List<MovieSession> movieSessions;

    public Cinema(String name) {
        this.name = name;
        this.cinemaHalls = new ArrayList<>();
        this.movieSessions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

    public List<MovieSession> getMovieSessions() {
        return movieSessions;
    }

    public void addCinemaHall(CinemaHall hall) {
        cinemaHalls.add(hall);
    }

    public void addMovieSession(MovieSession session) {
        movieSessions.add(session);
    }
}

public class TicketSystem {
    private List<Cinema> cinemas;

    public TicketSystem() {
        this.cinemas = new ArrayList<>();
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void displayCinemas() {
        System.out.println("Available cinemas:");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.getName());
        }
    }

    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();

        // Create cinemas, cinema halls, and movie sessions
        Cinema cinema1 = new Cinema("Cinema 1");
        CinemaHall hall1 = new CinemaHall(20);
        MovieSession session1 = new MovieSession("Movie 1", 120, "15:00", hall1);
        cinema1.addCinemaHall(hall1);
        cinema1.addMovieSession(session1);
        ticketSystem.addCinema(cinema1);

        // TODO: Add more cinemas, cinema halls, and movie sessions

        // Display available cinemas
        ticketSystem.displayCinemas();

        // TODO: Implement the rest of the functionalities (selling tickets, displaying seat plan, etc.)
    }
}