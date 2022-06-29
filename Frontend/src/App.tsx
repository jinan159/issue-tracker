import React from 'react';
import { ThemeProvider } from 'styled-components';

import Router from './router';
import GlobalStyle from './style/global';
import theme from './style/theme';

export default function App() {
  return (
    <div className="app">
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Router />
      </ThemeProvider>
    </div>
  );
}
