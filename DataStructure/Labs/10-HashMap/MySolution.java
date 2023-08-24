public class CourseGradebook extends Gradebook {

    protected HashMap<String, HashMap<Integer, Double>> gradebookData;

    public CourseGradebook() {
        gradebookData = new HashMap<>();
    }

    @Override
    public double getScore(String assignmentName, Integer studentID) {
        if(gradebookData.containsKey(assignmentName) && gradebookData.get(assignmentName).containsKey(studentID)) {
            return gradebookData.get(assignmentName).get(studentID);
        }
        return Double.NaN;
    }

    @Override
    public void setScore(String assignmentName, Integer studentID, Double score) {
        gradebookData.computeIfAbsent(assignmentName, k -> new HashMap<>()).put(studentID, score);
    }

    @Override
    public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
        return gradebookData.getOrDefault(assignmentName, new HashMap<>());
    }

    @Override
    public ArrayList<String> getSortedAssignmentNames() {
        ArrayList<String> assignmentNames = new ArrayList<>(gradebookData.keySet());
        Collections.sort(assignmentNames);
        return assignmentNames;
    }

    @Override
    public ArrayList<Integer> getSortedStudentIDs() {
        Set<Integer> studentIDs = new HashSet<>();
        for(HashMap<Integer, Double> studentData : gradebookData.values()) {
            studentIDs.addAll(studentData.keySet());
        }
        ArrayList<Integer> sortedStudentIDs = new ArrayList<>(studentIDs);
        Collections.sort(sortedStudentIDs);
        return sortedStudentIDs;
    }

    @Override
    public HashMap<String, Double> getStudentScores(Integer studentID) {
        HashMap<String, Double> studentScores = new HashMap<>();
        for(Map.Entry<String, HashMap<Integer, Double>> entry : gradebookData.entrySet()) {
            if(entry.getValue().containsKey(studentID)) {
                studentScores.put(entry.getKey(), entry.getValue().get(studentID));
            }
        }
        return studentScores;
    }
}
