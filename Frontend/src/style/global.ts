import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`
  ${reset}

  input {
    border: none;
    outline: none;
    background-color: transparent;
  }

  button {
    border: none;
    cursor: pointer;
  }
`;

export default GlobalStyle;
