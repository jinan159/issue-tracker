import styled from 'styled-components';

export const Container = styled.div`
  ${({ theme: { mixins } }) => `
		${mixins.flexBox('column', 'center', 'center')};
		width: 80%;
		height: 80%;
		margin: 0 auto;
	`}
`;

export const Content = styled.h1`
  color: #007aff;
  font-size: 48px;
  font-weight: 700;
  padding: 20px;
`;

export const LoadingSpinner = styled.div`
  margin: 0 auto;
  border: solid 15px;
  border-radius: 50%;
  border-color: #007aff #007aff transparent transparent;
  width: 100px;
  height: 100px;
  animation: spinning 0.8s infinite;
  @keyframes spinning {
    from {
      transform: rotate(0);
    }
    to {
      transform: rotate(360deg);
    }
  }
`;
