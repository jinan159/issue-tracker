import styled from 'styled-components';

const Button = styled.button`
  background: none;
  &:disabled {
    color: grey;
    cursor: default;
    &:hover {
      color: grey;
    }
  }
`;

export { Button };
