import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Login from './pages/Login';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        {/* <Route path="/main" element={<Main />} /> */}
        {/* <Route path="/label" element={<Label />} /> */}
        {/* <Route path="/mileStone" element={<MileStone />} /> */}
        {/* <Route path="/issue/create" element={<IssueCreate />} /> */}
        {/* <Route path="/issue/:id" element={<Issue />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
