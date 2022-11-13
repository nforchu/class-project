import { createContext, useState } from "react";

export const CustomerContext = createContext({
    currentCustomer: null,
    setCurrentCustomer: () => {}
});

export const CustomerProvider = ({children}) => {
  const [currentCustomer, setCurrentCustomer] = useState(null);
  const value  = {currentCustomer, setCurrentCustomer};
  
  return <CustomerContext.Provider value={value}>{children}</CustomerContext.Provider>
}

