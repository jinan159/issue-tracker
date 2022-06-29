import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Issue from '../pages/Issue';
import Loading from '../pages/Loading';
import Login from '../pages/Login';
import Main from '../pages/Main';

function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/main" element={<Main />} />
        <Route path="/loading" element={<Loading />} />
        {/* <Route path="/label" element={<Label />} /> */}
        {/* <Route path="/mileStone" element={<MileStone />} /> */}
        {/* <Route path="/issue/create" element={<IssueCreate />} /> */}
        <Route path="/issue/:id" element={<Issue />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
