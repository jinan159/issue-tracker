import React, {
  createContext,
  SetStateAction,
  useMemo,
  useState,
  Dispatch,
  useEffect,
} from 'react';
import { useCookies } from 'react-cookie';

type LoginStatus = {
  status: boolean;
  profileUrl: string;
};

type LoginStatusContextType = {
  loginStatus: LoginStatus;
  setLoginStatus: Dispatch<SetStateAction<LoginStatus>>;
};

export const LoginStatusContext = createContext<LoginStatusContextType>({
  loginStatus: {
    status: false,
    profileUrl: '',
  },
  setLoginStatus: () => {},
});

const initLoginStatus = {
  status: false,
  profileUrl: '',
};

export function LoginStatusProvider({
  children,
}: {
  children: JSX.Element | JSX.Element[];
}) {
  const [loginStatus, setLoginStatus] = useState<LoginStatus>(initLoginStatus);
  const [cookies] = useCookies();

  const loginStatusContext = useMemo(
    () => ({ loginStatus, setLoginStatus, isLogin }),
    [loginStatus]
  );

  const isLogin = () => {
    const accessToken = localStorage.getItem('token');
    const { refreshToken } = cookies;
    const hasAccessToken = accessToken !== null;
    const hasRefreshToken = refreshToken !== undefined;
    return hasAccessToken && hasRefreshToken;
  };

  useEffect(() => {
    if (isLogin()) {
      setLoginStatus({ ...loginStatus, status: true });
    }
  }, []);

  return (
    <LoginStatusContext.Provider value={loginStatusContext}>
      {children}
    </LoginStatusContext.Provider>
  );
}
