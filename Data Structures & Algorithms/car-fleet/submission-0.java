class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            carList.add(new Car(position[i], speed[i],
             (double) (target-position[i])/speed[i]));
        }
        List<Car> sortedList = carList.stream()
            .sorted(Comparator.comparing(Car::getPosition).reversed())
            .collect(Collectors.toList());

        int fleets = 0;
        double fleetTime = 0;
        for (int i = 0; i < sortedList.size(); i++) {
            if (fleetTime < sortedList.get(i).getHour()) {
                fleets++;
                fleetTime = sortedList.get(i).getHour();
            } 
        } 

        return fleets;
    }


    private class Car {
        int position;
        int speed;
        double hour;

        Car(int position, int speed, double hour) {
            this.position = position;
            this.speed = speed;
            this.hour = hour;
        }

        int getPosition() { return position; }
        double getHour() { return hour; }
    }
}
