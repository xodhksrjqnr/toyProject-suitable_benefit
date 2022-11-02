import PostList from "./PostList";
import TagList from "./TagList";
import '../../css/Dashboard.css'

function Dashboard() {
    return (
        <div className="dashboard">
            <PostList/>
            <TagList/>
        </div>
    );
}

export default Dashboard;