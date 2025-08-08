import { useEffect, useState } from "react";
import { Navigate, Outlet } from "react-router-dom";
import Loading from '../pages/loading'
import api from './Api'

export default function PrivateRoute() {

    const token = localStorage.getItem('accessToken')

    return token ? <Outlet /> : <Navigate to="/login" replace />

}

