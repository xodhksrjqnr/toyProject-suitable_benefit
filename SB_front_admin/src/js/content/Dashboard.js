import PostList from "./PostList";
import ConditionList from "./ConditionList";
import '../../css/Dashboard.css'

function Dashboard() {
    return (
        <div className="dashboard">
            <PostList/>
            <ConditionList/>
        </div>
    );
}

export default Dashboard;